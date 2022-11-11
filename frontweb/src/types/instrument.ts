import { Department } from "./department"

export type Instrument = {
    id: number;
	tag: string;
	description: string;
	type: string;
	range: string;
	frequency: string;
	lastCalibration: string;
	status: string;
	note: string;
	department: Department;
}