import axios from "axios";
export default axios.create({
  baseURL: "http://localhost:8080/api/transferencia",
  headers: {
    "Content-type": "application/json"                          
  }
});