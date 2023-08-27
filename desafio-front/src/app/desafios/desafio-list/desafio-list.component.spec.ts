import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DesafioListComponent } from './desafio-list.component';

describe('DesafioListComponent', () => {
  let component: DesafioListComponent;
  let fixture: ComponentFixture<DesafioListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DesafioListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DesafioListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
