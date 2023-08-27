import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';

import { DesafioListComponent } from './desafio-list/desafio-list.component';
import { DesafioComponent } from "./desafio/desafio.component";

@NgModule({
    declarations: [ 
        DesafioComponent, 
        DesafioListComponent ],
    exports: [ 
        DesafioListComponent ],
    imports: [
        CommonModule,
        HttpClientModule
     ]
})
export class DesafioModule {

}