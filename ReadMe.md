<p align="center" style="font-size:30px; font-weight:700"> Anti-Cheat System </p>

<p align="center"  >Basic Anti-Cheat System for Perfect World Private Servers</p>
This anti-cheat system working with any perfect world version.
this won't be 100% solution to stop scripters and hackers still you can add suspecting keywords in to the CheatEngineWords.txt
make sure that you didnt add any keyword like system, localhost. your players will get banned for nothing.

---
**gacd should start with this params**
```bash
-print_interface_debug_init_code_clientinfo_query_punish_question_skeleton_mutate_pp_acdatasend
```

#### Example of GACD
```bash
cd $PW_PATH/gacd;
./gacd  -print_interface_debug_init_code_clientinfo_query_punish_question_skeleton_mutate_pp_acdatasend gamesys.conf >$PW_PATH/gacd/gacd.log &
```
