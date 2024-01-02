import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Desafio } from './desafio/desafio';
import { ResponseDto } from '../shared/common/dtos/response-dto';
import { environment } from 'src/environments/environment';

import { map } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class DesafioService {

  constructor(private http: HttpClient) { 

  }

  searchByPergunta(pergunta: string) {
    console.log("Enviando " + pergunta);
    const ResponseDto = this.http.get<ResponseDto<Array<Desafio>>>(environment.apis.apiUrl + "api/v1/desafios/" + pergunta);
    return ResponseDto.pipe(map(response => response.result));
  }
}
