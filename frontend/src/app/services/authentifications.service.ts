import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { UserAppModel } from '../models/userApp.model';

@Injectable({
  providedIn: 'root',
})
export class AuthentificationsService {
  appUsers: UserAppModel[] = [];
  authenticatUser: UserAppModel | undefined | any;

  constructor() {
    // Initialize the appUsers array with some sample user data
    this.appUsers.push({
      userId: 2,
      username: 'adam',
      password: 'bouafia',
      roles: ['ADMIN', 'USER'],
    });
    this.appUsers.push({
      userId: 1,
      username: 'user',
      password: 'user',
      roles: ['USER'],
    });
    this.appUsers.push({
      userId: 3,
      username: 'admin',
      password: 'admin',
      roles: ['ADMIN'],
    });

    // Check for authenticated user in local storage on initialization
    const storedUser = localStorage.getItem('user');
    if (storedUser) {
      const { username, roles } = JSON.parse(storedUser);
      this.authenticatUser = { username, roles, password: '' };
    }
  }

  /**
   * Logs in a user with the provided username and password.
   * @param username - The username of the user.
   * @param password - The password of the user.
   * @returns An Observable that emits the UserAppModel if the login is successful, or throws an error if the user doesn't exist or the password is incorrect.
   */
  public login(username: string, password: string): Observable<UserAppModel> {
    let userAppModel = this.appUsers.find((user) => user.username == username);
    if (userAppModel == undefined) {
      return throwError(() => new Error("this user doesn't exist"));
    }
    if (userAppModel.password != password) {
      return throwError(() => new Error('password incorrect'));
    }
    return of(userAppModel);
  }

  /**
   * Authenticates a user and stores the user information in local storage.
   * @param user - The UserAppModel representing the authenticated user.
   * @returns An Observable that emits true if the authentication is successful.
   */
  public authenticat(user: UserAppModel): Observable<boolean> {
    this.authenticatUser = user;
    localStorage.setItem(
      'user',
      JSON.stringify({
        username: user.username,
        roles: user.roles,
        jwt: 'JWT Athentification',
      })
    );
    return of(true);
  }

  /**
   * Checks if the authenticated user has a specific role.
   * @param role - The role to check.
   * @returns A boolean indicating whether the authenticated user has the specified role.
   */
  public hasRole(role: string): boolean {
    return this.authenticatUser!.roles.includes(role);
  }

  /**
   * Checks if a user is authenticated.
   * @returns A boolean indicating whether a user is authenticated.
   */
  public isAuthenticat(): boolean {
    return this.authenticatUser != undefined;
  }

  /**
   * Logs out the authenticated user and removes the user information from local storage.
   * @returns An Observable that emits true if the logout is successful.
   */
  public logout(): Observable<boolean> {
    this.authenticatUser = undefined;
    localStorage.removeItem('user');
    return of(true);
  }
}
