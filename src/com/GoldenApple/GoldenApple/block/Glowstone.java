
use pocketmine\item\Item;

class Glowstone extends Transparent{
	public function __construct(){
		parent::__construct(self::GLOWSTONE_BLOCK, 0, "Glowstone");
		$this->hardness = 1.5;
	}

	public function getDrops(Item $item){
		return [
			[Item::GLOWSTONE_DUST, 0, mt_rand(2, 4)],
		];
	}
}