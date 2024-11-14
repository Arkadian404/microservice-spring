import Login from "../pages/Login";
import { BrowserRouter as Router, Routes, Route } from "react-";

const AppRoutes = () => {
  return (
    <Router>
      <Routes>
        <Route path="/login" element={<Login />} />
      </Routes>
    </Router>
  );
};
