import { Component, Input } from '@angular/core';

import { Desafio } from './desafio';

@Component({
    selector: 'ap-desafio',
    templateUrl: './desafio.component.html'
})
export class DesafioComponent {

    @Input() pergunta: string = '';
    @Input() resposta: string = '';
}