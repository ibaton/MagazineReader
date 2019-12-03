package se.treehou.newsmanager

import se.treehou.newsmanager.model.Body.BodyImage
import se.treehou.newsmanager.model.Body.BodyText
import se.treehou.newsmanager.model.NewsArticle

val article1 = NewsArticle(
    id = "0359bc68-5631-433e-9811-5ca38d23acb9",
    source = "https://www.theguardian.com/lifeandstyle/2019/nov/25/vegan-runners-can-a-plant-based-diet-provide-what-you-need-to-compete-and-win",
    title = "Vegan runners: can a plant-based diet provide what you need to compete – and win?",
    promoImage = "https://i.guim.co.uk/img/media/94ae0e43df717290e6a6b9dc92abccc2a82b32a4/0_223_3000_1800/master/3000.jpg?width=1225&quality=85&auto=format&fit=max&s=61aee3dc8d236c0ce57c234a48e3ea89",
    preamble = "Fiona Oakes was a lone crusader when she set up a running club for vegans 15 years ago. Now, she holds four world records",
    body = listOf(
        BodyText(
            "“In 2004, I was the only vegan in the village,” says Fiona Oakes, a multi-world-record-breaking marathon runner. “But now you see vegan runners everywhere.”\n" +
                    "\n" +
                    "An animal lover who set up her own animal sanctuary, Oakes started a running club called Vegan Runners in 2004. The idea came about after she saw the long-distance runner Paula Radcliffe on TV and spotted an opportunity. Oakes was a good runner and thought that, if she got faster, she could end up alongside Radcliffe at the start line of the London marathon, on national television, with the words “Vegan Runners” emblazoned across her vest.\n" +
                    "\n" +
                    "“It was a way of showcasing the cause,” she says. “I’d been vegan since I was six years old. I’d lost my kneecap from an illness when I was 17 and been told I would never run again. If I could do this as a vegan, it showed that anything was possible.”\n" +
                    "\n" +
                    "Back then she was a lone crusader, trying to introduce people to the word “vegan” in a positive way. “Rather than cause disruption and be in people’s faces, by running, I was leading by example and generating interest in a positive way,” she says.\n" +
                    "\n" +
                    "She went on to twice finish in the top 20 in major marathons, with a personal best of two hours 38 minutes, and also won the north pole marathon. Oakes’ powerful example has seen the Vegan Runners steadily increase their numbers over the years. But with the interest in veganism growing, partly in response to the global climate crisis, the club’s numbers have swelled exponentially in the past three years; there are almost 4,000 today, with more than 40 local groups across the country, their distinctive tops unmissable at races."
        ),
        BodyImage("https://i.guim.co.uk/img/media/bf5b955fd73a63d09f49938ec08043407d8120b1/0_0_2120_3184/master/2120.jpg?width=620&quality=85&auto=format&fit=max&s=642577ffdd57230b9f6f3d6f60f6e25e"),
        BodyText(
            "Club activities vary at each branch, but typically involve weekly training runs and group attendance at events such as local parkruns – usually with a visit to a vegan cafe afterwards.\n" +
                    "\n" +
                    "Understandably, members are expected to be vegan not just in their diet but in their choice of clothing. Oakes says that the expectation is for members to be living a fully plant-based lifestyle.\n" +
                    "\n" +
                    "Mike Exton from Sheffield joined Vegan Runners in June. Although he is vegan, he primarily joined because the training runs were local. “I do find it a little tricky being pigeonholed as a vegan runner,” he says. But he feels more comfortable wearing the Vegan Runners vest now than he might have done five years ago, as veganism has become “less weird”.\n" +
                    "\n" +
                    "“In many ways it’s just another running club,” he says, “though we do tend to chat about food, recommending things to try and getting advice on nutrition.”\n" +
                    "\n" +
                    "Lisa Gawthorne joined Vegan Runners in 2018. She says it is great to be surrounded by like-minded people and that the club forms “a really kind and compassionate running community”.\n" +
                    "\n" +
                    "“I think it’s important to bounce off people who are going through similar things to you and to share experiences,” she says. “This may include tips on nutrition or the best vegan running shoes. It all helps.” Most running shoes that don’t use leather or suede are vegan, but sometimes the glues used in shoes can be made from animal products. The Vegan Runners’ website has a helpful guide to which brands are fully vegan.\n" +
                    "\n" +
                    "Gawthorne has been vegan for 16 years and is an international road runner and duathlon athlete. She believes being vegan has helped her to perform at such a high level. “It improves recovery time, is better for the digestive system and promotes better sleep,” she says. “I have never had as much energy as I have since moving from a vegetarian to a vegan diet.”\n" +
                    "\n" +
                    "Not everyone shares this view. Tim Noakes, a South African sports scientist famous for his promotion of a high-fat, meat-rich diet, says a vegan diet is “incomplete in so many ways”. “In time, a truly vegan athlete will run into trouble unless they are sourcing additional animal-based nutrients – such as vitamin B12, iron, choline and probably high-quality proteins – from somewhere else,” he says.\n" +
                    "\n" +
                    "Dietitian Renee McGregor, who works with international ultra-runners, says that while it is possible to be vegan and a good runner, it needs a lot of careful planning. “In my clinic, many of the athletes that come in with relative energy deficiency have become vegan,” she says, adding that the high intake of fibre more common in a vegan diet can impact the absorption of nutrients such as iron and calcium, as well as displace energy intake.\n" +
                    "\n" +
                    "There are not enough long-term studies to show how vegan diets impact athletic performance, which leaves us with a battleground of anecdotal evidence. Some of the world’s leading long-distance runners swear by the meat-heavy diet promoted by Noakes, while others are vegan, spearheaded by the legendary ultra-runner Scott Jurek, whose seven consecutive victories in the most competitive ultra-marathon in the US, the Western States 100-mile endurance run, make the case that a vegan diet doesn’t have to be incompatible with running.\n" +
                    "\n" +
                    "For Oakes, proving this to the world is what gets her out of bed on cold mornings. “It gives me a reason to get up and train,” she says. “To show what is possible, and to promote what I believe in.”"
        )
    )
)

val article2 = NewsArticle(
    id = "182c06de-a515-46dc-b271-711f24d79747",
    source = "https://www.theguardian.com/lifeandstyle/2019/nov/20/no-downside-day-trip-just-dont-call-it-a-daycation",
    title = "There is no downside to a day trip – just don’t call it a 'daycation'",
    promoImage = "https://i.guim.co.uk/img/media/cc92a1d3cb543b6e8d05277fde8a8c498b0e8771/0_192_5760_3456/master/5760.jpg?width=620&quality=85&auto=format&fit=max&s=fe46ecfbc455acdbc3af15be976e6c2e",
    preamble = "A miniature jaunt to British pebbles or historical cities is a way of experiencing the world in bitesize",
    body = listOf(
        BodyText(
            "OK, let’s get the bad out of the way: the portmanteau “daycation”, a monstrous offshoot of the almost-equally offensive “staycation”. Given that I believe day trips are 12-hour delights, they do not deserve to be labelled in such a painful way.\n" +
                    "\n" +
                    "Wherever one lives, and whatever one feels about that place, there is never a downside to going on a miniature jaunt. It’s a means of experiencing the world in bitesize; broadening one’s horizons, but not too much. If the trip goes badly, it doesn’t matter, because: a) it is short and b) it has the effect of casting a new light on one’s regular environment.\n" +
                    "\n" +
                    "One thing wealthy people do not understand about those with lesser financial means (and judge them for) is how they manage to – shock horror – own mobile phones, or laptops, or things that cost a few bob. What they are missing is that people who can’t afford neverending luxuries will focus on treats to make the mundane bearable. Big treats saved up for, perhaps, or indulgences little and often.\n" +
                    "\n" +
                    "Most of us cannot afford always to take five-star holidays to white sands and waters as clear as vodka, but day trips to British pebbles or birch trees or historical cities are in reach. (At least, for non-drivers, when private rail companies aren’t charging hundreds for train tickets.)\n" +
                    "\n" +
                    "There are multiple thrills. The planning itself is exciting. Firing up Google Maps; browsing whatever the place has to offer and making a suggested itinerary, bookmarks galore. I want to visit art galleries, swim in the sea, eat Victoria sponge and sip at hand-warming coffee, pose outside National Trust homes as if I live there. I’ll admit I’ve never pulled off being “good” at museums. I guess I like my history to be under my feet, on location, or on the pages of a book.\n" +
                    "\n" +
                    "Though compiling the list of things to do (TripAdvisor reviews read; Instagram pictures scouted) is part of the fun, even more so is following one’s nose once there. Sometimes, a trip will be so successful it might spill overnight. This is even more likely when with close pals, who make the best companions for these explorations. (This level of spontaneity depends on the company. New lover? Tired children?)\n" +
                    "\n" +
                    "Domestic holidays pretty much fell out of fashion with the advent of budget flights; especially trips to seaside towns that Victorians enjoyed so much. But with a crappy economy, flight-shaming in the light of a climate crisis and our time-poor lifestyles, I’d argue they are on the rise again. So, see you at a bus station in the hinterland, checking timetables."
        )
    )
)