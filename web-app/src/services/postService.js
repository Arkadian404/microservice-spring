import httpClient from "../configurations/httpClient";
import {getToken} from "./localStorageService";
import {API} from "../configurations/configuration";


export const getMyPosts = async (page) =>{
    return await httpClient.get(API.MY_POSTS,{
        headers:{
            Authorization: `Bearer ${getToken()}`
        },
        params:{
            page: page,
            size: 10
        }
    });
}