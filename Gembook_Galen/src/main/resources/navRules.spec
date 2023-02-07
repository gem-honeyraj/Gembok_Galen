@objects
    side-bar    .sidebar_sidebar__swPYZ
            header   logo_header__yvMXi
            menu-list .sidebar_menu__3B2HB
                list-items-* li


@rule all test for nav bar
    @on desktop
        @for [ 1 - 12 ] as index
                side-bar.menu-list.list-items-${index}:
                    above side-bar.menu-list.list-items-${index+1}
                    inside side-bar

= Nav Rules =
    | all test for nav bar
