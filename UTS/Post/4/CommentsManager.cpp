#include "CommentsManager.hpp"
#include <algorithm>
#include <numeric>

void CommentsManager::kickSpammer(int threshold_score) {
    auto is_spammer = [&](const Comment& comment) {
        auto it = reputation_.find(comment.getUsername());
        if (it == reputation_.end()) {
            return false;
        }
        return it->second > threshold_score;
    };

    chat_log_.erase(
        std::remove_if(chat_log_.begin(), chat_log_.end(), is_spammer),
        chat_log_.end()
    );
}

void CommentsManager::printViolation() {
    std::string output = std::accumulate(
        chat_log_.begin(),
        chat_log_.end(),
        std::string(),
        [&](std::string acc, const Comment& comment) {
            const auto& words = comment.getWords();
            return std::accumulate(
                words.begin(),
                words.end(),
                std::move(acc),
                [&](std::string inner, const std::string& word) {
                    if (blacklist_.find(word) != blacklist_.end()) {
                        inner += "kata \"" + word + "\" oleh akun \"" + comment.getUsername() + "\"\n";
                    }
                    return inner;
                }
            );
        }
    );

    if (output.empty()) {
        std::cout << "TIDAK ADA PELANGGARAN\n";
        return;
    }

    std::cout << output;
}

std::string CommentsManager::quizWinner(const std::set<std::string>& passwords) {
    auto it = std::find_if(chat_log_.begin(), chat_log_.end(), [&](const Comment& comment) {
        const auto& words = comment.getWords();
        return std::any_of(words.begin(), words.end(), [&](const std::string& word) {
            return passwords.find(word) != passwords.end();
        });
    });

    if (it == chat_log_.end()) {
        return "BELUM ADA PEMENANG";
    }

    return it->getUsername();
}

void CommentsManager::upVIPComment() {
    std::stable_partition(chat_log_.begin(), chat_log_.end(), [](const Comment& comment) {
        return comment.isVip();
    });
}
