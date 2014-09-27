
use pocketmine\item\Item;
use pocketmine\Player;

class Pumpkin extends Solid{
	public function __construct(){
		parent::__construct(self::PUMPKIN, "Pumpkin");
		$this->hardness = 5;
	}

	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		if($player instanceof Player){
			$this->meta = ((int) $player->getDirection() + 5) % 4;
		}
		$this->getLevel()->setBlock($block, $this, true, true);

		return true;
	}

}