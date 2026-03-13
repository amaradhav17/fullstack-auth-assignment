import { useState } from "react";
import api from "../services/api";

function Register() {

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [role, setRole] = useState("USER");

  const handleSubmit = async (e:any) => {
    e.preventDefault();

    const user = {
      name,
      email,
      password,
      role
    };

    try {
      const response = await api.post("/api/auth/register", user);
      alert(response.data);
    } catch (error) {
      console.error(error);
      alert("Registration Failed");
    }
  };

  return (
    <div>
      <h2>Register</h2>

      <form onSubmit={handleSubmit}>

        <input
          type="text"
          placeholder="Name"
          onChange={(e)=>setName(e.target.value)}
        />

        <br/>

        <input
          type="email"
          placeholder="Email"
          onChange={(e)=>setEmail(e.target.value)}
        />

        <br/>

        <input
          type="password"
          placeholder="Password"
          onChange={(e)=>setPassword(e.target.value)}
        />

        <br/>

        <select onChange={(e)=>setRole(e.target.value)}>
          <option value="USER">USER</option>
          <option value="ADMIN">ADMIN</option>
        </select>

        <br/><br/>

        <button type="submit">Register</button>

      </form>

    </div>
  );
}

export default Register;