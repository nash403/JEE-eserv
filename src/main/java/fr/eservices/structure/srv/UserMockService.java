package fr.eservices.structure.srv;

import fr.eservices.structure.model.UserMock;
import fr.eservices.structure.model.RoleMock;

public class UserMockService {

  private static UserMock currentUser = new UserMock("Jean", "Dupond", "jean.dupond@gmail.com", "motdepasse", RoleMock.ADMIN);

  public static UserMock getCurrentUser() {
    return currentUser;
  }

  public static void changeUser() {
    if(currentUser.getRole() == RoleMock.ADMIN)
      currentUser.setRole(RoleMock.RIGGER);
    else
      currentUser.setRole(RoleMock.ADMIN);
  }

}
