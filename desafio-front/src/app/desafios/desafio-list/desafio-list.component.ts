import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { debounceTime } from 'rxjs/operators'; 

import { DesafioService } from '../desafio.service';
import { Desafio } from '../desafio/desafio';

@Component({
  selector: 'app-desafio-list',
  templateUrl: './desafio-list.component.html'
})
export class DesafioListComponent implements OnInit, OnDestroy {

  desafios: Desafio[] = [];
  debounce: Subject<string> = new Subject<string>();

  constructor(private desafioService: DesafioService) {  }

  ngOnInit(): void {
    this.debounce
      .pipe(debounceTime(300)) //Ignore frantic request until 300 miliseconds.
      .subscribe(filter => {
        this.search(filter);
    });
  }

  ngOnDestroy(): void {
    this.debounce.unsubscribe();
  }

  search(filter: string): void {
    this.desafioService.searchByPergunta(filter)
      .subscribe(dados => {
        this.desafios = dados;
      });
  }
}
