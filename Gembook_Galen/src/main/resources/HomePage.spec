@import navRules.spec

@objects
    event-card          xpath   (//*[@class='card-body' ])[1]
    awards-card         xpath   (//*[@class='card-body' ])[2]
    birthday-card       xpath   (//*[@class='card-body' ])[3]
    anniversary-card    xpath   (//*[@class='card-body' ])[4]
    new-member-card     xpath   (//*[@class='card-body' ])[5]
    write-post-block    .writePost_card__2Fl_c

@groups
    right-cards     event-card, awards-card, birthday-card, anniversary-card, new-member-card

= Main =
    @on desktop
        &right-cards:
            aligned vertically all event-card

        write-post-block:
            height ~128px
            width   ~738px

