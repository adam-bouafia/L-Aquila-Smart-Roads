/**
 * Represents a user application model.
 */
export interface UserAppModel {
  /**
   * The unique identifier of the user.
   */
  userId: number;

  /**
   * The username of the user.
   */
  username: string;

  /**
   * The password of the user.
   */
  password: string;

  /**
   * The roles assigned to the user.
   */
  roles: string[];
}
