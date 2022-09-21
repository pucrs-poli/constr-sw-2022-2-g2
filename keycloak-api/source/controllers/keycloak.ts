import { Request, Response, NextFunction } from "express";
import axios, { AxiosResponse } from "axios";

// login in keycloak
const login = async (req: Request, res: Response) => {
  // get the realm from the request params
  let realm: string = req.params.realm;
  // get the data from req.body
  let client_id: string = req.body.client_id;
  let client_secret: string = req.body.client_secret;
  let username: string = req.body.username;
  let password: string = req.body.password;
  // login in keycloak
  const params = new URLSearchParams();
  params.append("client_id", client_id);
  params.append("client_secret", client_secret);
  params.append("username", username);
  params.append("password", password);
  params.append("grant_type", "password");

  let response: AxiosResponse = await axios.post(
    `http://localhost:8080/auth/realms/${realm}/protocol/openid-connect/token`,
    params
  );

  // return response
  return res.status(200).json(response.data);
};

const userInfo = async (req: Request, res: Response) => {
  // get the realm from the request params
  let realm: string = req.params.realm;
  // get the token from the request header
  let token: string = req.headers.authorization || "";
  // get the user info
  let response: AxiosResponse = await axios.get(
    `http://localhost:8080/auth/realms/${realm}/protocol/openid-connect/userinfo`,
    {
      headers: {
        Authorization: token,
      },
    }
  );

  // return response
  return res.status(200).json(response.data);
};

const getUsers = async (req: Request, res: Response) => {
  let realm: string = req.params.realm;
  let token: string = req.headers.authorization || "";
  let response: AxiosResponse = await axios.get(
    `http://localhost:8080/${realm}/users`,
    {
      headers: {
        Authorization: token,
      },
    }
  );

  return res.status(200).json(response.data);
}

const getUserById = async (req: Request, res: Response) => {
  let realm: string = req.params.realm;
  let id: string = req.params.id;
  let token: string = req.headers.authorization || "";
  let response: AxiosResponse = await axios.get(
    `http://localhost:8080/${realm}/users/${id}`,
    {
      headers: {
        Authorization: token,
      },
    }
  );

  return res.status(200).json(response.data);
}

export default { login, userInfo, getUsers, getUserById };

// Language: typescript
