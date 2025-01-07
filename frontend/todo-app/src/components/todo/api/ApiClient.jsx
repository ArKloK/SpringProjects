import axios from "axios";

export const apiClient = axios.create(
    {
        baseURL: 'http://localhost:8090',
        headers: {
            'Access-Control-Allow-Origin': '*'
        }
    }
)