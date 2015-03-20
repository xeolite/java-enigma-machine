x-enigma
========

The Enigma cipher machine, written in Java 8.

 * M3 and M4 military variants implemented
 * Support for all machine settings
 * Support for creating custom rotors, reflectors and machines
 * Formatted output

####Configuration
As an example we'll use the following codebook entry for the M3 machine:
```
------------------------------------------------------------------------------
| Tag | UKW |   Walzenlage    | Ringstellung |      Steckerverbindungen      |
------------------------------------------------------------------------------
| 31  |  C  | VII   III  I    |   26 04 11   | BN DF EL HV JQ KW MZ PR SX UY |
```

This tells us that for the 31st day of the month, the settings are:

 * Reflector C
 * Rotors VII, III, I
 * Ring settings 26 (Z), 04 (D), 11 (K)
 * Plugboard connection pairs B=N, D=F etc.

The 'ring settings' are an offset of each rotor's wiring in relation to the rest of the rotor body.
The operators could then choose their own start positions for the rotors.
Let's choose a start position for the three rotors with X, E and O facing upward in the machine.
The machine is then put together like this:

```java
    Enigma enigma = new EnigmaM3(
            StandardReflector.C,
            StandardRotor.VII.withSetting(Letter.Z).startAt(Letter.X),
            StandardRotor.III.withSetting(D).startAt(E),
            StandardRotor.I.withSetting(K).startAt(O),
            new Plugboard()
                    .connect(B, N).connect(D, F).connect(E, L)
                    .connect(H, V).connect(J, Q).connect(K, W)
                    .connect(M, Z).connect(P, R).connect(S, X)
                    .connect(U, Y));
```


####Encryption / decryption

Now we're ready to encrypt a message. The encryption is case-insensitive and any non-alphabetic characters are ignored
as Enigma only supports the characters A-Z.


```java
enigma.encipher("If you want to keep a secret, you must also hide it from yourself.",
        OutputStyle.groupsOf(5));
```
Which gives us
```
MQQWF AYPYF FYXWZ TJFIW USLMX JHMDC FULVX TVBCG UTAXE AJPLU D
```

Decrypting the message requires it to be input to a machine in exactly the same starting state as the machine that encrypted it and then
```java
enigma.encipher("MQQWF AYPYF FYXWZ TJFIW USLMX JHMDC FULVX TVBCG UTAXE AJPLU D");
```
gives us the alphabetic content of the original message
```
IFYOUWANTTOKEEPASECRETYOUMUSTALSOHIDEITFROMYOURSELF
```


The M4 variant adds a thin fourth rotor to the machine by combining this with a special thin reflector, so that it is configured like this:

```java
    Enigma enigma = new EnigmaM4(
            ThinReflector.B_THIN,
            ThinRotor.GAMMA.withSetting(Letter.X).startAt(Letter.S),
            StandardRotor.I.withSetting(M).startAt(P),
            StandardRotor.II.withSetting(J).startAt(D),
            StandardRotor.III.withSetting(H).startAt(T),
            new Plugboard()
                    .connect(A, U).connect(F, O).connect(K, R)
                    .connect(I, S).connect(D, P).connect(X, W));
```
Encryption and decryption are performed in the same way as for the M3.


####Custom components

Custom rotors and reflectors can also be created. The cipher used by these components can be represented using a string of 26 letters,
such that its first letter will be the result of enciphering A, the second of enciphering B, etc., as commonly used in Enigma
descriptions.

Reflectors can be created in this way:
```java
StandardReflector A = new StandardReflector("EJMZALYXVBWFCRQUONTSPIKHGD");
```

Rotors are most easily defined by creating a reusable RotorConfiguration with the cipher alphabet and the turnover positions:
```java
RotorConfiguration<StandardRotor> X1 = new RotorConfiguration<>(StandardRotor::new,
        "MIBPUYDQTXKWRFSCJAZEVHNOLG", Letter.M, Letter.B);

StandardRotor left = X1.withSetting(Letter.D).startAt(Letter.R);
```

Custom machines can also be created, based on the mechanism of the military Enigma. Here's a two-rotor variant with no plugboard:
```java
    public class SmallEnigma extends Enigma {

        public SmallEnigma(StandardReflector reflector,
                            StandardRotor left,
                            StandardRotor right) {

            super(new EnigmaMechanism(reflector, new RotorGroup(left, right),
                    new LeverGroup(2), Stator.MILITARY, new Plugboard()));
        }

    }
```
