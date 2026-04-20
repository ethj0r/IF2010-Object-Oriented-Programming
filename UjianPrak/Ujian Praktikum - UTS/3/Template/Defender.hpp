#ifndef DEFENDER_HPP
#define DEFENDER_HPP

#include "Footballer.hpp"

class Defender : public Footballer
{
protected:
  // atribut tambahan tackleSuccess (jumlah tackle sukses)
  // dan interceptions (jumlah intercept)
  // ...

public:
  // Default constructor
  // set atribut Footballer dengan nilai default,
  // set tackleSuccess dan interceptions ke 0, dan playPosition ke "defender"
  // ...

  // User-defined constructor
  // parameter: string name, int birthYear, int tackleSuccess, int interceptions
  // set atribut dengan nilai parameter, playPosition tetap "defender"
  // nationality, height, dan weight gunakan nilai default superclass
  // ...

  // Getter dan Setter untuk tackleSuccess
  // setTackleSuccess(...)
  // getTackleSuccess()

  // Getter dan Setter untuk interceptions
  // setInterceptions(...)
  // getInterceptions()

  // Method tambahan: defensiveRating
  // rumus: (tackleSuccess * 2) + interceptions
  // return dalam bentuk int
  // ...

  // Override transferRate:
  // rumus: (600.000 * tackleSuccess) + (400.000 * interceptions)
  // hasil berupa int
  // ...

  // Override displayInfo():
  // Cetak info Footballer + atribut tambahan defender (tackleSuccess, interceptions, defensiveRating)
  // Format:
  // Tackle Success: <tackleSuccess>
  // Interceptions: <interceptions>
  // Defensive Rating: <defensiveRating>
  // ...
};

#endif
