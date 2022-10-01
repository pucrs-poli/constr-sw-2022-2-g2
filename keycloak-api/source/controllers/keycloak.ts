import { Request, Response, NextFunction } from "express";
import axios, { AxiosResponse } from "axios";

const realm = "constr-sw-2022-2";

// login in keycloak
const login = async (req: Request, res: Response) => {
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

  let response: AxiosResponse = await axios.post(
    `http://localhost:8080/auth/realms/${realm}/protocol/openid-connect/token`,
    params
  );

  return res.status(200).json(response.data);
};
//userinfo
const userInfo = async (req: Request, res: Response) => {
  let token: string = req.headers.authorization || "";
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
  let token: string = req.headers.authorization || "";

  let response: AxiosResponse = await axios.get(
    `http://localhost:8080/auth/admin/realms/${realm}/users`,
    {
      headers: {
        Authorization: token,
      },
    }
  );

  return res.status(200).json(response.data);
};

const getUserById = async (req: Request, res: Response) => {
  let id: string = req.params.id;
  let token: string = req.headers.authorization || "";
  let response: AxiosResponse = await axios.get(
    `http://localhost:8080/auth/admin/realms/${realm}/users/${id}`,
    {
      headers: {
        Authorization: token,
      },
    }
  );

  return res.status(200).json(response.data);
};

const createUser = async (req: Request, res: Response) => {
  let token: string = req.headers.authorization || "";
  let response: AxiosResponse = await axios.post(
    `http://localhost:8080/auth/admin/realms/${realm}/users`,
    {
      headers: {
        Authorization: token,
      },
      data: req.body,
    }
  );

  return res.status(200).json(response.data);
};

const deleteUser = async (req: Request, res: Response) => {
  let id: string = req.params.id;
  let token: string = req.headers.authorization || "";
  let response: AxiosResponse = await axios.delete(
    `http://localhost:8080/auth/admin/realms/${realm}/users/${id}`,
    {
      headers: {
        Authorization: token,
      },
    }
  );

  return res.status(200).json(response.data);
};

const updateUserData = async (req: Request, res: Response) => {
  let id: string = req.params.id;
  let token: string = req.headers.authorization || "";
  let response: AxiosResponse = await axios.put(
    `http://localhost:8080/auth/admin/realms/${realm}/users/${id}`,
    {
      headers: {
        Authorization: token,
      },
      data: res.json(req.body),
    }
  );

  return res.status(200).json(response.data);
};

const updateUserPassword = async (req: Request, res: Response) => {
  let id: string = req.params.id;
  let token: string = req.headers.authorization || "";
  let response: AxiosResponse = await axios.put(
    `http://localhost:8080/auth/admin/realms/${realm}/users/${id}/reset-password`,
    {
      headers: {
        Authorization: token,
      },
      data: res.json(req.body),
    }
  );

  return res.status(200).json(response.data);
};

export default {
  login,
  userInfo,
  getUsers,
  getUserById,
  createUser,
  deleteUser,
  updateUserData,
  updateUserPassword,
};
