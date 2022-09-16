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

  const params = new URLSearchParams();
  params.append("client_id", client_id);
  params.append("client_secret", client_secret);
  params.append("username", username);
  params.append("password", password);
  params.append("grant_type", "password");

  let response: AxiosResponse = await axios.post(`http://localhost:8080/auth/realms/${realm}/protocol/openid-connect/token`, params);

  // return response
  return res.status(200).json(response.data);
};

export default { login };