import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ProfileComponent } from './profile/profile.component';
import { GroupsComponent } from './groups/groups.component';
import { FeedComponent } from './feed/feed.component';
import { ExploreComponent } from './explore/explore.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'navbar2', component: RegisterComponent},
  {path: 'feed', component: FeedComponent},
  {path: 'groups', component: GroupsComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'explore', component: ExploreComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
