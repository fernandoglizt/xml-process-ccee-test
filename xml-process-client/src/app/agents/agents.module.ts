import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { AgentsRoutingModule } from './agents-routing.module';
import { AgentsComponent } from './agents.component';


@NgModule({
  declarations: [
    AgentsComponent
  ],
  imports: [
    CommonModule,
    AgentsRoutingModule,
    AppMaterialModule,
    SharedModule
  ]
})
export class AgentsModule { }
