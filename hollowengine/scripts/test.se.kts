val team by server.players
val modium by NPCEntity.creating {
    name = "Модиум" //Имя персонажа
    model = "is:models/npc/Mindos.gltf" //Путь к модели персонажа
    attributes = Attributes( //список атрибутов персонажа (здоровье, скорость и т.п.) - всё как в команде /attribute
        "minecraft:generic.max_health" to 10000f,
        "minecraft:generic.movement_speed" to 0.2f, //к примеру здоровье
    )
    animations[AnimationType.IDLE] = "mindosmorgaet"
    showName = true //показывать ли ник с именем над нпс
    pos = pos(230.04, 70.00, 6.45) //координаты где спавнить нпс
}
modium lookAlwaysAt team

wait{2.sec}
modium play {
    animation = "mindosmorgaet" // Название анимации
    layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    playType = PlayMode.LOOPED // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    speed = 1f // Скорость анимации
}