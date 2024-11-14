import { API } from "../configurations/configuration";
import httpClient from "../configurations/httpClient";

export const getMyInfo = async () => {
  return await httpClient.get(API.MY_INFO, {
    headers: {},
  });
};
