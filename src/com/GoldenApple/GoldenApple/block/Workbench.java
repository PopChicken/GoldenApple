
use pocketmine\item\Item;
use pocketmine\Player;

//TODO: check orientation
class Workbench extends Solid{
	public function __construct($meta = 0){
		parent::__construct(self::WORKBENCH, $meta, "Crafting Table");
		$this->isActivable = true;
		$this->hardness = 15;
	}

	public function onActivate(Item $item, Player $player = null){
		if($player instanceof Player){
			$player->craftingType = 1;
		}

		return true;
	}

	public function getDrops(Item $item){
		return [
			[$this->id, 0, 1],
		];
	}
}