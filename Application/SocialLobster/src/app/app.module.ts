
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { NavbarComponent } from './shared/menu/navbar/navbar.component';
import { LoginComponent } from './pages/login/login.component';
import { Navbar2Component } from './shared/menu/navbar2/navbar2.component';
import { RegisterComponent } from './pages/register/register.component';
import { FeedComponent } from './pages/feed/feed.component';
import { GroupsComponent } from './pages/groups/groups.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { ExploreComponent } from './pages/explore/explore.component';
import { MaterialModule } from './shared/material/material.module';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatCardModule } from '@angular/material/card';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { HttpClientModule } from '@angular/common/http';
import { UserListComponent } from './pages/components/user-list/user-list.component';
import { AdminComponent } from './pages/admin/admin.component';
import { CommentsComponent } from './pages/components/listings/comments/comments.component';
import { LocationComponent } from './pages/components/listings/location/location.component';
import { MessageComponent } from './pages/components/listings/message/message.component';
import { PhotosComponent } from './pages/components/listings/photos/photos.component';
import { PostComponent } from './pages/components/listings/post/post.component';
import { SchoolComponent } from './pages/components/listings/school/school.component';
import { UserdataComponent } from './pages/components/listings/userdata/userdata.component';
import { WorkplaceComponent } from './pages/components/listings/workplace/workplace.component';
import { NontrivialComponent } from './pages/nontrivial/nontrivial.component';


/*
//material:
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatSelectModule } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';
import { MatSidenav } from '@angular/material/sidenav';
import { MatTabsModule } from '@angular/material/tabs';





//other imports:
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule } from '@angular/forms';

*/


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    RegisterComponent,
    Navbar2Component,
    FeedComponent,
    GroupsComponent,
    ProfileComponent,
    ExploreComponent,
    UserListComponent,
    AdminComponent,
    CommentsComponent,
    LocationComponent,
    MessageComponent,
    PhotosComponent,
    PostComponent,
    SchoolComponent,
    UserdataComponent,
    WorkplaceComponent,
    NontrivialComponent,
  ],
  imports: [


    MaterialModule, MatInputModule, MatButtonModule, MatSelectModule, MatRadioModule, MatCardModule, ReactiveFormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    BrowserModule,
    LayoutModule,
    MatToolbarModule,
    MatSidenavModule,
    MatIconModule,
    FormsModule,
    HttpClientModule,
    MatListModule


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
