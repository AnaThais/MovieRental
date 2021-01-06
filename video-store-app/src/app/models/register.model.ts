import { Client } from './client.model';
import { Movie } from './movie.model';

export class Register {
    id: number;
    client: Client;
    movie: Movie;
    endDate: string;
    startDate: string;
 }