import Home from "../pages/Home";
import Login from "../pages/Login";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Profile from "../pages/Profile";

const AppRoutes = () => {
  return (
    <Router>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/" element={<Home />} />
        <Route path="/profile" element={<Profile />} />
      </Routes>
    </Router>
  );
};

export default AppRoutes;
