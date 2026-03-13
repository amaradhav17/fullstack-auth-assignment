import { useState } from "react";
import api from "../services/api";

function Login() {

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = async (e:any) => {
    e.preventDefault();

    const loginData = {
      email: email,
      password: password
    };

    try {

      const response = await api.post("/api/auth/login", loginData);

      alert("Login Successful");

      console.log(response.data);

      window.location.href = "/user";

    } catch (error) {

      console.error(error);
      alert("Login Failed");

    }

  };

  return (

    <div>

      <h2>Login</h2>

      <form onSubmit={handleLogin}>

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

        <br/><br/>

        <button type="submit">Login</button>

      </form>

    </div>

  );
}

export default Login;