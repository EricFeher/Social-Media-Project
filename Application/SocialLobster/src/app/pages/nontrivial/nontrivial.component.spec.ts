import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NontrivialComponent } from './nontrivial.component';

describe('NontrivialComponent', () => {
  let component: NontrivialComponent;
  let fixture: ComponentFixture<NontrivialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NontrivialComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NontrivialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
