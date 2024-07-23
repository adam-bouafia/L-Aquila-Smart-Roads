/**
 * Represents a vehicle.
 */
export interface Vehicle {
  /**
   * The unique identifier of the vehicle.
   */
  id: number;

  /**
   * The registration number of the vehicle.
   */
  registrationNumber: string;

  /**
   * The brand of the vehicle.
   */
  brand: string;

  /**
   * The fiscal power of the vehicle.
   */
  fiscalPower: string;

  /**
   * The model of the vehicle.
   */
  model: string;

  /**
   * The owner of the vehicle.
   */
  owner: any;
}
