import { Department } from "./department";

export type User = {
    id: number;
    name: string;
    email: string;
    department: Department
}