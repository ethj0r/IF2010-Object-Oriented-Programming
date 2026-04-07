#include "WeaponInventory.hpp"

/**
 * @brief Menambahkan senjata baru ke inventaris.
 * @param id ID unik senjata.
 * @param name Nama senjata.
 * @param type Tipe senjata (Sword/Bow/Staff).
 * @param damage Nilai damage senjata.
 * @param rarity Tingkat kelangkaan (1-5).
 */
void WeaponInventory::add(const string &id, const string &name, const string &type, int damage, int rarity) {
    weapons.push_back(Weapon(id, name, type, damage, rarity));
}

/**
 * @brief Menghapus senjata berdasarkan id.
 * @param id ID senjata yang akan dihapus.
 * @return true jika senjata ditemukan dan dihapus, false jika tidak
 * ditemukan.
 */
bool WeaponInventory::remove(const string &id) {
    auto it = std::find_if(weapons.begin(), weapons.end(), [&id](const Weapon& t) {
        return t.id == id;
    });
    if (it != weapons.end()) {
        weapons.erase(it);
        return true;
    }
    return false;
}

/**
 * @brief Mencari senjata berdasarkan id.
 * @param id ID senjata yang dicari.
 */
const Weapon *WeaponInventory::find(const string &id) const {
    auto it = std::find_if(weapons.begin(), weapons.end(), [&id](const Weapon& t) {
        return t.id == id;
    });
    return (it != weapons.end()) ? &(*it) : nullptr;
}

/**
 * @brief Memperbarui data senjata yang sudah ada berdasarkan id.
 * @param id ID senjata target.
 * @param name Nama baru.
 * @param type Tipe baru.
 * @param damage Damage baru.
 * @param rarity Rarity baru.
 */
void WeaponInventory::update(const string &id, const string &name, const string &type, int damage, int rarity) {
    auto it = std::find_if(weapons.begin(), weapons.end(), [&id](const Weapon& t) {
        return t.id == id;
    });

    if (it != weapons.end()) {
        it->id = id;
        it->name = name;
        it->type = type;
        it->damage = damage;
        it->rarity = rarity;
    }
}

/**
 * @brief Mengurutkan senjata.
 * @details Urutan: rarity menurun, jika sama damage menurun, jika masih sama id menaik (leksikografis).
 */
void WeaponInventory::sort() {
    std::sort(weapons.begin(), weapons.end(), [](const Weapon& a, const Weapon& b) {
        if (a.rarity != b.rarity) return a.rarity > b.rarity;
        if (a.damage != b.damage) return a.damage > b.damage;
        return a.id < b.id;
    });
}

/**
 * @brief Menghitung total damage semua senjata bertipe tertentu.
 * @param type Tipe senjata yang dihitung.
 * @return Total damage.
 */
long long WeaponInventory::totalDamage(const string &type) const {
    return accumulate(weapons.begin(), weapons.end(), 0LL, [type](long long sum, const Weapon& t) {
        return sum + (t.type == type ? t.damage : 0LL);
    });
}

/**
 * @brief Menghitung jumlah senjata dengan rarity >= minRarity.
 * @param minRarity Batas minimum rarity.
 * @return Jumlah senjata yang memenuhi syarat.
 */
int WeaponInventory::countByRarity(int minRarity) const {
    return count_if(weapons.begin(), weapons.end(), [minRarity](const Weapon& w) {
        return w.rarity >= minRarity;
    });
}

/**
 * @brief Menampilkan semua senjata bertipe tertentu menggunakan iterator.
 * @param type Tipe senjata yang ditampilkan.
 * @details Cetak "EMPTY" jika tidak ada senjata bertipe tersebut.
 */
void WeaponInventory::printByType(const string &type) const {
    bool found = false;
    for (const auto& w : weapons) {
        if (w.type == type) {
            cout << w.id << "|" << w.name << "|" << w.type << "|" << w.damage << "|" << w.rarity << "\n";
            found = true;
        }
    }
    if (!found) cout << "EMPTY\n";
}

/**
 * @brief Menampilkan seluruh senjata sesuai urutan saat ini di container.
 * @details Cetak "EMPTY" jika container kosong.
 */
void WeaponInventory::print() const {
    if (weapons.empty()) {
        cout << "EMPTY\n";
        return;
    }
    for (const auto& w : weapons) {
        cout << w.id << "|" << w.name << "|" << w.type << "|" << w.damage << "|" << w.rarity << "\n";
    }
}

/**
 * @brief Menambahkan bonus damage ke semua senjata bertipe tertentu.
 * @param type Tipe senjata yang di-upgrade.
 * @param bonusDamage Nilai tambahan damage.
 * @return Jumlah senjata yang ter-upgrade.
 */
int WeaponInventory::upgradeAll(const string &type, int bonusDamage) {
    int count = 0;
    for (auto& w : weapons) {
        if (w.type == type) {
            w.damage += bonusDamage;
            count++;
        }
    }
    return count;
}
