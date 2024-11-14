import { API } from "../configurations/configuration";
import httpClient from "../configurations/httpClient";
import { getToken, removeToken, setToken } from "./localStorageService";

export const logIn = async (username, password) => {
  const response = await httpClient.post(API.LOGIN, {
    username: username,
    password: password,
  });
  console.log(response.data);
  //   setToken(response?.data?.result?.token);
  return response;
};

export const logOut = () => {
  removeToken();
};

export const isAuthenticated = () => {
  return getToken();
};
