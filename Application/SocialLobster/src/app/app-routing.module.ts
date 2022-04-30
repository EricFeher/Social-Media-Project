import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { FeedComponent } from './pages/feed/feed.component';
import { ExploreComponent } from './pages/explore/explore.component';
import { UserListComponent } from './pages/components/user-list/user-list.component';
import { AdminComponent } from './pages/admin/admin.component';
import {AuthGuard} from "./shared/services/auth.guard";
import {NontrivialComponent} from "./pages/nontrivial/nontrivial.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'feed', component: FeedComponent,
    canActivate: [AuthGuard]},
  {path: 'profile', component: ProfileComponent,
    canActivate: [AuthGuard]},
  {path: 'explore', component: ExploreComponent,
    canActivate: [AuthGuard]},
  {path: 'userlist', component: UserListComponent,
    canActivate: [AuthGuard]},
  {path: 'admin', component: AdminComponent,
    canActivate: [AuthGuard]},
  {path: 'nontrivial', component: NontrivialComponent}
];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
