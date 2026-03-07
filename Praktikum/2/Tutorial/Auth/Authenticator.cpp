#include "Authenticator.hpp"

Authenticator::Authenticator() {
    // cout << "Ini adalah data rahasia!" << endl;
    secretResource = "Ini adalah data rahasia!";
    userCount = 0;
    currentUser = nullptr;
}

void Authenticator::registerUser(const string &username, const string &password, bool isAdmin) {
    if (userCount == MAX_USERS) {
        cout << "Gagal: Kapasitas user penuh!" << endl;
        return;
    }

    for (int i=0; i<userCount; i++) {
        if (username == users[i]->getUsername()) {
            cout << "Gagal: Username sudah digunakan!" << endl;
            return;
        }
    }

    if (isAdmin) {
        users[userCount] = new AdminUser(username, password);
    } else {
        users[userCount] = new User(username, password);
    }   
    userCount++;
    cout << "Sukses: User " << username << " berhasil terdaftar!" << endl;;
}

void Authenticator::login(const string &username, const string &password) {
    for (int i=0; i<userCount; i++) {
        if (username==users[i]->getUsername() && users[i]->checkPassword(password)) {
            currentUser = users[i];
            cout << "Sukses: Login berhasil! Selamat datang, " << username << "." << endl;
            return;
        }
    }
    cout << "Gagal: Username atau password salah!" << endl;
}

void Authenticator::logout() {
    if (currentUser == nullptr) {
        cout << "Gagal: Tidak ada user yang sedang login!" << endl;
        return;
    }
    cout << "Sukses: User " << currentUser->getUsername() << " telah logout." << endl;
    currentUser = nullptr;
}

void Authenticator::accessResource() const {
    if (currentUser == nullptr) {
        cout << "Akses ditolak! Silakan login terlebih dahulu." << endl;
        return;
    }

    cout << "Resource: " << secretResource << endl;
}

void Authenticator::setResource(const string &newResource) {
    if (currentUser == nullptr) {
        cout << "Gagal: Tidak bisa mengubah resource! Silakan login terlebih dahulu." << endl;
        return;
    }

    if (!(currentUser->isAdmin())) {
        cout << "Gagal: Tidak bisa mengubah resource! Hanya admin yang dapat melakukan ini." << endl;
        return;
    }

    this->secretResource = newResource;
    cout << "Sukses: Resource telah diperbarui oleh " << currentUser->getUsername() << "." << endl;
}

Authenticator::~Authenticator() {
    for (int i = 0; i < userCount; i++) {
        // cout << "Delete User " << users[i]->getUsername() << "." << endl;
        delete users[i];
    }
}