
use pocketmine\item\Item;
use pocketmine\level\Level;
use pocketmine\math\AxisAlignedBB;
use pocketmine\Player;

class Cake extends Transparent{
	public function __construct($meta = 0){
		parent::__construct(self::CAKE_BLOCK, 0, "Cake Block");
		$this->isFullBlock = false;
		$this->isActivable = true;
		$this->meta = $meta & 0x07;
		$this->hardness = 2.5;
	}

	public function getBoundingBox(){
		$f = (1 + $this->getDamage() * 2) / 16;

		return new AxisAlignedBB(
			$this->x + $f,
			$this->y,
			$this->z + 0.0625,
			$this->x + 1 - 0.0625,
			$this->y + 0.5,
			$this->z + 1 - 0.0625
		);
	}

	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		$down = $this->getSide(0);
		if($down->getID() !== self::AIR){
			$this->getLevel()->setBlock($block, $this, true, true);

			return true;
		}

		return false;
	}

	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_NORMAL){
			if($this->getSide(0)->getID() === self::AIR){ //Replace with common break method
				$this->getLevel()->setBlock($this, new Air(), true);

				return Level::BLOCK_UPDATE_NORMAL;
			}
		}

		return false;
	}

	public function getDrops(Item $item){
		return [];
	}

	public function onActivate(Item $item, Player $player = null){
		if($player instanceof Player and $player->getHealth() < 20){
			++$this->meta;
			$player->heal(3, "cake");
			if($this->meta >= 0x06){
				$this->getLevel()->setBlock($this, new Air(), true);
			}else{
				$this->getLevel()->setBlock($this, $this, true);
			}

			return true;
		}

		return false;
	}

}