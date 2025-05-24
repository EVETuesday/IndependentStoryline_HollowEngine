val team by server.players
val md by NPCEntity.creating {
    name = "Миндос"
    model = "is:models/npc/Mindos3.gltf"
    pos = pos(200, 69, 50)
    showName = false
    animations[AnimationType.IDLE] = "mindosmorgaet"
}
md.waitInteract()
md lookAlwaysAt team

md say {"Кто ты и откуда тут?"}
md playOnce{"mindoszlitca"}
wait{3.sec}
md playLooped {"mindosmorgaet"}
md say {"Наши приборы показывали, что на этой планете отсутствует всякая живность."}
wait{3.sec}
execute{"/say Я-я не знаю... Я очнулся тут и не помню, как тут оказался..."}
wait{3.sec}
md playOnce{"mindospodozrevaet"}
md say{"Что ж, окей, разберемся... Я Миндос. Великий воин королевства Аксе-02."}
wait{4.sec}
// ответ гельмо
wait{3.sec}
md say {"При одном из сражений с королевским бортом, корабль был поврежден, и я был вынужден приземлиться тут."}
wait{3.sec}
md say{"Починить надо, сечёшь?"}
wait{3.sec}
// ответ гельмо
wait{3.sec}
async{
    md playOnce {"mindospodozrevaet"}
}
md say{"Больно ты любопытный для ничего не помнящего. Ты случаем не королевский агент? "}
//ответ гельмо
wait{3.sec}
md say{"И что же нам с тобой делать, Гелма..."}
wait{2.sec}
//ответ гельмо
wait{3.sec}
md say{"Нам. Я с командой тут. Мои ребята разбежались и ищут ресурсы, а я остался здесь и налаживаю датчики навигации. "}
wait{4.sec}
md say{"Ну, хорошо, дополнительная помощь не будет лишней... Добудь ресурсов там каких-нибудь. Иди, короче. Дадут тебе задание. Сейчас передам команде, что у нас незнакомец, неожиданно свалившийся нам на голову. "}