val players by server.players
val player = players().first()

val interactGerdec = async {
    val gerdec by NPCEntity.creating {
        name = "Гердес"
        model = "is:models/npc/gerdec.gltf"
        textures["classic"] = ""
        animations[AnimationType.IDLE] = "gerdecmorgaet"
    	animations[AnimationType.WALK] = "walk"
        showName = false
        pos = pos(209.5, 74, 55.5)
    }
    gerdec lookAlwaysAt{pos(210, 75, 55.5)}
	While ({true}) {
		gerdec.waitInteract()
    	gerdec lookAlwaysAt{player}
        wait{2.sec}
		gerdec say{"О, ты похоже тот малец, о котором босс говорил."}
		wait{4.sec}
  		gerdec say{"Приятно познакомиться! Я Гердес."}
		wait{4.sec}
   		players say{"Приятно, Я Гельмо."}
		wait{4.sec}
    	gerdec say{"Гельмо? Интересное имя."}
        wait{4.sec}
        gerdec say{"Иди-ка с остальными поздоровайся, не мешай мне. "}
        wait{2.sec}
        gerdec lookAlwaysAt{pos(210, 75, 55.5)}
        wait{2.sec}
        gerdec say{"Я уже жду этот момент, когда увижу морду Модиума и, смотря ему в глаза, скажу, какой же он мерзавец! "}
	}
}

val interactFanzia = async {
    val fanzia by NPCEntity.creating {
        name = "Фанзия"
        model = "is:models/npc/fanzia.gltf"
        textures["classic"] = ""
        animations[AnimationType.IDLE] = "fanziamorgaet"
    	animations[AnimationType.WALK] = "walk"
        showName = false
        pos = pos(197.5, 74, 62.5)
    }
    fanzia lookAlwaysAt{pos(197, 75.5, 62.5)}
	While ({true}) {
            fanzia.waitInteract()
    		fanzia lookAlwaysAt{player}
            wait{2.sec}
            fanzia say{"Здравствуй, новенький, я - Фанзия."}
            wait{4.sec}
            fanzia say{"Я недавно в этом отряде."}
            wait{4.sec}
            fanzia say{"Уже две недели сражаюсь с Модиумом и его армией!"}
            wait{4.sec}
            players say{"Привет, я - Гельмо."}
            wait{4.sec}
            players say{"Рад, что я не один здесь новый."}
            wait{4.sec}
            players say{"А то я чувствую себя не в своей тарелке…"}
            wait{6.sec}
            players say{"Хотя я ничего не знаю о поступках Модиума, но вы, ребята, кажетесь неплохими. "}
            wait{6.sec}
            players say{"Постараюсь помочь чем смогу."}
            wait{3.sec}
            fanzia lookAlwaysAt{pos(197, 75.5, 62.5)}
	}
}

val mindos by NPCEntity.creating {
    name = "Миндос"
    model = "is:models/npc/Mindos.gltf"
    textures["classic"] = ""
    animations[AnimationType.IDLE] = "mindosmorgaet"
    animations[AnimationType.WALK] = "walk"
    showName = false
    pos = pos(200.5, 69, 50.5)
    
    rotation = vec(0,-180)
}
mindos lookAlwaysAt{pos(200.5, 70.5, 50)}

val alfia by NPCEntity.creating {
    name = "Альфия"
    model = "is:models/npc/alfia.gltf"
    textures["classic"] = ""
    animations[AnimationType.IDLE] = "alfiamorgaet"
    animations[AnimationType.WALK] = "walk"
    showName = false
    pos = pos(178.5, 74, 61.5)
    
    rotation = vec(0,-180)
}
alfia lookAlwaysAt{pos(177.5, 75.5, 61.5)}

mindos.requestItems{
	+item("minecraft:emerald",5)
	+item("independent_storyline:wrench",1)
}

mindos say{"Добыл? Молодец."}
wait{4.sec}
mindos say{"Что же делать-то с тобой..."}
wait{4.sec}
mindos say{"Ай, ладно, возьмем тебя с собой."}
wait{4.sec}
mindos say{"Не оставлять же тебя погибать и гнить тут, жалко красавца."}
wait{6.sec}
mindos say{"Я уже жду этот момент, когда увижу морду Модиума и, смотря ему в глаза, скажу, какой же он мерзавец!"}

execute{"/fill 230 72 61 230 72 57 minecraft:deepslate_tile_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]"}
execute{"/fill 231 71 61 231 71 57 minecraft:deepslate_tile_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]"}
execute{"/fill 232 70 61 232 70 57 minecraft:deepslate_tile_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]"}
execute{"/fill 233 69 61 233 69 57 minecraft:deepslate_tile_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]"}

execute{"/setblock 233 69 59 minecraft:deepslate_brick_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]"}
execute{"/setblock 232 70 59 minecraft:deepslate_brick_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]"}
execute{"/setblock 231 71 59 minecraft:deepslate_brick_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]"}
execute{"/setblock 230 72 59 minecraft:deepslate_brick_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]"}

execute{"/fill 229 73 61 229 78 57 minecraft:air"}

alfia.waitInteract()

alfia lookAlwaysAt{player}
alfia say{"Альфия. Миндос сказал к тебе подойти и ты выдашь мне вещи."}
wait{4.sec}
alfia say{"Ага, Гельмо. "}
wait{4.sec}
alfia say{"Не думала, что найдем здесь хоть кого-то, но, раз уж так сложилось..."}
wait{4.sec}
alfia say{"Хотя Миндос и сказал, что ты просто ничего не помнящий дурачок, я все равно тебе не доверяю."}
alfia playOnce{"alfiapodozrevaet"}
wait{6.sec}
alfia.stopLookAlways()
alfia moveTo{pos(183.5,74,61)}
alfia say{"За мной. Выдам тебе броню и меч."}
wait{1.sec}
alfia moveTo{pos(186.5,74,59.5)}
alfia moveTo{pos(209,74,59.5)}
alfia moveTo{pos(208,74,55.5)}
alfia moveTo{pos(203.5,74,55)}
wait{1.sec}
alfia lookAlwaysAt{player}
wait{2.sec}
alfia dropItem { item("independent_storyline:legendary_sword") }
alfia dropItem { item("magistuarmory:ceremonial_chestplate") }
alfia dropItem { item("magistuarmory:ceremonial_boots") }
alfia dropItem { item("independent_storyline:alfia_amulet") }
alfia dropItem { item("independent_storyline:gerdes_amulet") }
alfia dropItem { item("independent_storyline:fanzia_amulet") }
alfia say{"Этих амулетов у нас мало, так что выделю тебе лишь один."}
wait{4.sec}
alfia say{"Можешь испытать их на улице."}
wait{4.sec}
alfia say{"Подойди потом ко мне и выбери, какой у тебя останется. "}
wait{4.sec}
alfia say{"Не смей ничего вытворять! Я слежу за тобой."}
wait{4.sec}
alfia say{"Малейшее действие, которое меня смутит — и я тебя выкину без сожалений. Уяснил?"}
wait{6.sec}
alfia say{"Не смей ничего вытворять!"}

alfia.waitInteract()

alfia say{"Ты, быстро! Что выбрал?"}
wait{4.sec}
dialogue {
	choice(ChoiceAction.WORLD){
		players say{"Какой амулет ты оставишь себе?"}
		"Амулет Альфии"{
			players say{"Амулет Альфии"}
			execute{"/clear @a independent_storyline:gerdes_amulet"}
			execute{"/clear @a independent_storyline:fanzia_amulet"}
		}
		"Амулет Гердеса"{
			players say{"Амулет Гердеса"}
			execute{"/clear @a independent_storyline:alfia_amulet"}
			execute{"/clear @a independent_storyline:fanzia_amulet"}
		}
		"Амулет Фанзии"{
			players say{"Амулет Фанзии"}
			execute{"/clear @a independent_storyline:alfia_amulet"}
			execute{"/clear @a independent_storyline:gerdes_amulet"}
		}
	}
}

alfia say{"Миндос велел посвятить в наши планы, так что слушай. "}
wait{4.sec}
alfia say{"Подлетев на корабле, мы высадимся в городе."}
wait{4.sec}
alfia say{"Я, Миндос и Фанзия взлетим и будем обстреливать крышу с корабля."}
wait{4.sec}
alfia say{"Ты и Гердес останетесь в небесном городе."}
wait{4.sec}
alfia say{"Гердес пойдет на наш склад в городе и свяжется с другими группировками."}
wait{4.sec}
alfia say{"Ты же попробуй войти в здание, если получится, то найди Модиума и следи за ним. "}
wait{4.sec}
players say{"Альфия, могу я задать вопрос? "}
wait{4.sec}
players say{"Что сделал Модиум? "}
wait{4.sec}
players say{"Зачем он захватил власть?"}
wait{4.sec}
alfia say{"Он мерзавец, который лишь завидовал всем."}
wait{4.sec}
alfia say{"Захотел абсолютной власти."}
wait{4.sec}
alfia say{"Гельмо, послушай..."}
wait{4.sec}
alfia say{"Я запомню этот день навсегда."}
wait{4.sec}
alfia say{"Я приехала к своим родителям, как внезапно началась атака..."}
wait{4.sec}
alfia say{"Воздушные военные корабли, которые подчинялись Модиуму атаковали жилые дома, потому что думали, что там пряталось правительство."}
wait{8.sec}
alfia say{"Атаковали и мой дом..."}
wait{4.sec}
alfia say{"Мой отец закрыл меня своим телом."}
wait{4.sec}
alfia say{"Я выжила тогда, получила травмы."}
wait{4.sec}
alfia say{"Cквозь боль пыталась откопать останки близких, которые погибли..."}
wait{4.sec}
alfia say{"Этого достаточно, чтобы ненавидеть Модиума?"}
wait{4.sec}
alfia lookAlwaysAt{pos{203,75.5,55}}
players say{"Да, прости."}
wait{4.sec}
players say{"Я не знал..."}
wait{4.sec}
players say{"Мне жаль. "}
wait{4.sec}
players say{"Прими мои соболезнования."}
wait{4.sec}
alfia say{"Я лично выкину Модиума в разъяренную толпу, которая потеряла близких из-за него. "}
wait{6.sec}
alfia say{"Я дала клятву, что он поплатится за всё, что сделал."}
wait{6.sec}
alfia say{"Я лично дам ему по роже. "}
wait{4.sec}
alfia say{"Иди скажи Миндосу, что мы готовы лететь."}
wait{4.sec}
alfia playOnce{"vzdoh"}
alfia.waitInteract()
players say{"Альфия просила передать тебе, что мы готовы лететь."}
wait{4.sec}
mindos say{"Ага, понял. Значит летим."}
wait{4.sec}