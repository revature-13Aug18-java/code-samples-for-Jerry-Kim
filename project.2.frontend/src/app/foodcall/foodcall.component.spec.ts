import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodcallComponent } from './foodcall.component';

describe('FoodcallComponent', () => {
  let component: FoodcallComponent;
  let fixture: ComponentFixture<FoodcallComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FoodcallComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodcallComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
