import { API } from "../configurations/configuration";
import httpClient from "../configurations/httpClient";
import { setToken } from "./localStorageService";

export const logIn = async (username, password) => {
  const response = await httpClient.post(API.LOGIN, {
    username: username,
    password: password,
  });
  setToken(response?.data?.result?.token);
  return response;
};
