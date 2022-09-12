import { Request, Response, NextFunction } from "express";
import axios, { AxiosResponse } from "axios";

interface User {
  nome: string;
  idade: number;
}

interface IApiResponse {
  data: User;
}

// getting a single user
const getUser = async (req: Request, res: Response, next: NextFunction) => {
  // get the user id from the req
  let id: string = req.params.id;

  // get the mocked user
  let result: IApiResponse = {
    data: {
      nome: "Bruno",
      idade: 23,
    }
  }

  let user: User = result.data;
  return res.status(200).json({
    message: user,
  });
};

// adding a user
const addUser = async (req: Request, res: Response, next: NextFunction) => {
  // get the data from req.body
  let title: string = req.body.title;
  let body: string = req.body.body;

  // add the post
  let response: AxiosResponse = await axios.post(
    `https://jsonplaceholder.typicode.com/posts`,
    {
      title,
      body,
    }
  );
  
  // return response
  return res.status(200).json({
    message: response.data,
  });
};

export default { getUser, addUser };