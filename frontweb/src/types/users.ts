import { Department } from "./department";
import { Roles } from "./roles";

export type User = {
    id: number;
    name: string;
    enrollment: String;
    email: string;
    password: string;
    department: Department;
    roles: Roles[];
}