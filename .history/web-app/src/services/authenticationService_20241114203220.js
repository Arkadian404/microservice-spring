import { API } from "../configurations/configuration";
import httpClient from "../configurations/httpClient";

export const logIn = async (username, password) => {
  const response = await httpClient.post(API.LOGIN, {
    username: username,
    password: password,
  });
};
