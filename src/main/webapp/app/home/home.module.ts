import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { CalsoftJHipsterSampleSharedModule } from 'app/shared/shared.module';
import { HOME_ROUTE } from './home.route';
import { HomeComponent } from './home.component';

@NgModule({
  imports: [CalsoftJHipsterSampleSharedModule, RouterModule.forChild([HOME_ROUTE])],
  declarations: [HomeComponent],
})
export class CalsoftJHipsterSampleHomeModule {}
