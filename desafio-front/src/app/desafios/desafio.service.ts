import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Desafio } from './desafio/desafio';
import { ResponseDto } from '../dtos/response-dto';
import { map } from 'rxjs';

const API = "http://localhost:8082/"

@Injectable({
  providedIn: 'root'
})
export class DesafioService {

  constructor(private http: HttpClient) { 

  }

  searchByPergunta(pergunta: string) {
    console.log("Enviando " + pergunta);
    const ResponseDto = this.http.get<ResponseDto<Array<Desafio>>>(API + "api/v1/desafios/" + pergunta);
    return ResponseDto.pipe(map(response => response.result));
  }
}
