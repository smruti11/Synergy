import React, { useState } from 'react';
import axios from '../utils/axios';
function Login({ setAuthToken }) {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const handleSubmit = async e => {
    e.preventDefault();
    const res = await axios.post('/api/auth/login', { username, password });
    localStorage.setItem('token', res.data.token); // store JWT
    setAuthToken(res.data.token);
  };
  return (
    <form onSubmit={handleSubmit}>
      <input value={username} onChange={e => setUsername(e.target.value)} />
      <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
      <button type="submit">Login</button>
    </form>
  );
}
export default Login;