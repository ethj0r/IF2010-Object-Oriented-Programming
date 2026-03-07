#include <iostream>
#include "Authenticator.hpp"
#include "AdminUser.hpp"
#include "User.hpp"

using namespace std;

int main() {
    // User person = new User("jordhy", "12345678");
    // User person("jordhy", "12345678");
    // cout << person.getUsername() << endl;

    Authenticator auth;

    auth.registerUser("Jordhy", "pass123", false);
    auth.registerUser("Emilio", "pass123", false);
    auth.registerUser("AdminJor", "pass123", true);

    auth.login("Jordhy", "pass123");
    auth.accessResource();
    auth.logout();

    auth.login("AdminJor", "pass123");
    auth.accessResource();
    auth.setResource("The Sandbox 3.0.");
    auth.accessResource();


    return 0;
}